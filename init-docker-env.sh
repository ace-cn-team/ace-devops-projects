#!/bin/bash
# 初始化 docker jenkins的环境配置
yum install -y wget
wget http://dl.fedoraproject.org/pub/epel/epel-release-latest-7.noarch.rpm
rpm -ivh epel-release-latest-7.noarch.rpm
yum install -y jq
#
yum install -y docker
#
wget https://dl.k8s.io/v1.18.6/kubernetes-client-linux-amd64.tar.gz && \
tar -zxvf kubernetes-client-linux-amd64.tar.gz && \
cd kubernetes/client/bin && \
chmod +x ./kubectl && \
mv ./kubectl /usr/local/bin/kubectl
kubectl version
