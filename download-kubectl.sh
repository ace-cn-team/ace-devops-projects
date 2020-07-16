#!/bin/bash
# 下载kubeclt
wget https://dl.k8s.io/v1.18.6/kubernetes-client-linux-amd64.tar.gz && \
tar -zxvf kubernetes-client-linux-amd64.tar.gz && \
cd kubernetes/client/bin && \
chmod +x ./kubectl && \
mv ./kubectl /usr/local/bin/kubectl
kubectl version