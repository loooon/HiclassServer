# HiclassServer
微信小程序 《Hi 便校园》 服务端

# 2020.03.02 
* 完成了域名 www.hiclass.site 的解析，测试了 ssl 证书的部署，已经可以生效了
* 做了 80 端口转发到 443 端口，即始终是安全的 https 请求
* 小程序中登录后，调用微信的校验接口获取微信用户的 openID 和 sessionID

