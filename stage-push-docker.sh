#!/bin/bash
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

if [ $baseVersion ]; then
  baseVersion="baseVersion=${baseVersion}"
fi

#artifactId=sibu-mall-label-api
#nexus3Url="http://47.113.53.151/service/rest/v1/search/assets/download?sort=version&direction=desc&repository=maven-releases&maven.artifactId=${artifactId}"
nexus3Url="http://nexus3.ace.com:8081/service/rest/v1/search/assets/download?sort=version&direction=desc&repository=maven-releases&maven.artifactId=${artifactId}"
wget --content-disposition -P target ${nexus3Url}
jarPath="$(ls target/*.jar)"
#echo ${jarPath}
docker build \
-q  \
-t ${artifactId}:latest \
--build-arg JAR_PATH="${jarPath}" \
.