#!/bin/bash

#jdk下载地址
JDK_SOURCE_URI="http://autoscripts.tcy365.net:32639/centos/jdk8/jdk-8u151-linux-x64.rpm"

function warnEcho(){
    message=$1
    message="[WARN] "${message}
    echo $message
}
function errorEcho(){
    message=$1
    message="[ERROR] "${message}
    echo $message
}
function infoEcho(){
    message=$1
    message="[INFO] "${message}
    echo $message
}

function yum2package() {
    name=$1
    if [ `rpm -qa|grep $name|wc -l` -eq 0 ];then
        warnEcho "not found package "${name}
        infoEcho ">> begin to install "${name}
        yum -y install $name
    fi

    if [ `rpm -qa|grep $name|wc -l` -eq 0 ];then
        errorEcho ">> failed to install "${name}
        return 0
    else
        infoEcho ">> package "${name}" is available"
        return 1
    fi
}

OS_FILE="/etc/centos-release"
if [ ! -f "$OS_FILE" ]; then
    errorEcho ">> current script only apply to CentOS"
    exit 1
fi

if [ `rpm -qa|grep jdk1.8|wc -l` -ne 0 ];then
    infoEcho "JDK1.8 has been installed!"
    exit 0
fi

infoEcho '>> clean yum env...'
yum2package "yum-utils"
yum clean all
/usr/sbin/yum-complete-transaction --cleanup-only

infoEcho 'try to check packages...'
packages=('wget')
for package in ${packages[@]}; do
    infoEcho ">> checking "${package}"..."
    yum2package "${package}"
    if [ $? -ne 1 ]; then
        exit 1
    fi
done

jdkFileName=${JDK_SOURCE_URI##*/} 

infoEcho ">> clean local env..."
rm -rf ${jdkFileName}

infoEcho ">> try to download JDK1.8 source..."
wget ${JDK_SOURCE_URI}
if [ ! -f "$jdkFileName" ]; then
    errorEcho ">> failed to download "${jdkFileName}
    exit 1
fi

yum install ${jdkFileName} -y

if [ `rpm -qa|grep jdk1.8|wc -l` -ne 0 ];then
    warnEcho "JDK1.8 has been installed!"
else
    errorEcho ">> failed to install "${jdkFileName}
    exit 1
fi

echo '>> succeed!!'

