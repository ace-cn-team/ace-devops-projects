#####################################################################################
## 微服务jar包应该镜像打包
#####################################################################################
FROM openjdk:11.0.6-jre-buster

MAINTAINER Caspar "279397942@qq.com"

EXPOSE 8080

# 微服务jar包名称,例：target/ace-account-base-api.web-1.1.1.jar
ARG JAR_PATH
# JAR运行目录
ARG WORK_PATH=/ace/application
# 日志数据目录
ARG LOG_PATH=/ace/logs
#-server -Xms8G -Xmx8G -Xmn4G -Xss256k -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:$WORK_DATA/logs/gc_%p.log -XX:+UseGCLogFileRotation -XX:NumberOfGCLogFiles=5 -XX:GCLogFileSize=30m -XX:+HeapDumpOnOutOfMemoryError
ARG JAVA_OPTS='-server -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:$LOG_PATH/gc/gc_%p.log -XX:+UseGCLogFileRotation -XX:NumberOfGCLogFiles=5 -XX:GCLogFileSize=30m -XX:+HeapDumpOnOutOfMemoryError'

VOLUME ${WORK_PATH}
VOLUME ${LOG_PATH}

ADD ${JAR_PATH} ${WORK_PATH}/app.jar

# 输出JAVA_OPTS
RUN echo ${JAVA_OPTS}

# WORKDIR
WORKDIR $WORK_PATH

# 定义时区
RUN cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
&& echo 'Asia/Shanghai' > /etc/timezone

ENTRYPOINT java ${JAVA_OPTS} -jar app.jar -Djava.security.egd=file:/dev/./urandom