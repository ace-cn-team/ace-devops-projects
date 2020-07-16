#!/bin/bash
# 下载kubeclt
#wget https://dl.k8s.io/v1.18.5/kubernetes-client-linux-arm64.tar.gz
#tar -zxvf kubernetes-client-linux-arm64.tar.gz
#
kubectl rollout restart deployment -n ace ${artifactId}