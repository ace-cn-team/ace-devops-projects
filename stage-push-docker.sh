#!/bin/bash
########################################################################################################################
## 处理输入参数
########################################################################################################################
while getopts a:b: OPT; do
  case ${OPT} in
    a) artifactId=${OPTARG}
      ;;
    b) baseVersion=${OPTARG}
      ;;
    \?)
       printf "[Usage] $(date '+%F %T') a <artifactId> maven的artifactId " >&2
       exit 1
  esac
done

########################################################################################################################
## 函数定义
########################################################################################################################
function getArtifactDownloadUrl() {
    artifactId=$1
    nexus3SearchApiUrl="http://nexus3.ace.com:8081/service/rest/v1/search/assets?sort=version&direction=desc&repository=maven-releases&maven.artifactId=${artifactId}&maven.baseVersion=${baseVersion}"

    jsonResult=$(curl "${nexus3SearchApiUrl}")
    jsonArrayLength=$(echo ${jsonResult}|jq '.items|length')
    jsonArrayLength=$((10#${jsonArrayLength}-1))
    jsonItemArray=$(echo ${jsonResult}|jq ".items")


    for i in $(seq 0 1 ${jsonArrayLength})
      do
        artifactDownloadUrl=$(echo ${jsonResult}|jq ".items[${i}].downloadUrl")
        if [[ (${artifactDownloadUrl} == *.jar\" || ${artifactDownloadUrl} == *.war\") && ${artifactDownloadUrl} != *-sources.jar\" ]]
          then
            break
          else
            artifactDownloadUrl=""
        fi
      done
    echo ${artifactDownloadUrl}
}
########################################################################################################################
## 构建镜像，并上传镜像脚本开始
########################################################################################################################
echo "artifactId:${artifactId}"
echo "baseVersion:${baseVersion}"
# 微服务jar包下载地址
artifactDownloadUrl=$(getArtifactDownloadUrl "${artifactId}")
echo "${artifactDownloadUrl}"
# docker server 地址
dockerAgentServerAddr="tcp://devops-docker-server.ace.com:2375"
# 微服务jar包名称
jarName="app.jar"
# 微服务jar包保存路径
jarPath="target/${jarName}"
# 镜像仓库服务器
dockerHubUrl="nexus3.ace.com:8082"
# 镜像的tag,当前时间
imageTimeTag=$(date "+%y%m%d%H%M%S")
# 微服务镜像完全名称
imageName="${dockerHubUrl}/${artifactId}"
imageNameWithTimeTag="${dockerHubUrl}/${artifactId}:${imageTimeTag}"
imageNameWithLatestTag="${dockerHubUrl}/${artifactId}:latest"

echo "开始删除之前本地docker所有相关镜像"
docker -H ${dockerAgentServerAddr} rmi --force $(docker -H ${dockerAgentServerAddr} images -a |grep ${artifactId}|awk '{print $3}')||true
# 下载微服务jar包
echo "下载微服务jar包"
mkdir -p target
eval "wget --content-disposition -O ${jarPath} -P target "${artifactDownloadUrl}""
# 构建镜像
echo "开始构建镜像 ${imageNameWithTimeTag} ${imageNameWithLatestTag}"
mv dockerfile ./target
docker -H "${dockerAgentServerAddr}" build \
-f ./target/dockerfile \
-t "${imageNameWithTimeTag}" \
--build-arg JAR_PATH="${jarName}" \
"./target"
docker -H "${dockerAgentServerAddr}" tag ${imageNameWithTimeTag} ${imageNameWithLatestTag}
docker -H "${dockerAgentServerAddr}" login -u "${dockerUsername}" -p "${dockerPassword}" ${dockerHubUrl}
echo "上传镜像"
docker -H "${dockerAgentServerAddr}" push ${imageNameWithTimeTag}
docker -H "${dockerAgentServerAddr}" push ${imageNameWithLatestTag}
#docker logout  ${docker_hub_url}