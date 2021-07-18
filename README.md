# RabbitMQ学习笔记


启动rabbitmq:  
`/opt/rabbitmq/sbin/rabbitmq-server -detached`

停止rabbitmq:  
`/opt/rabbitmq/sbin/rabbitmqctl stop`

查看已开启的插件:   
`/opt/rabbitmq/sbin/rabbitmq-plugins list`

开启消息轨迹插件:  
`/opt/rabbitmq/sbin/rabbitmq-plugins enable rabbitmq_tracing`

启动消息轨迹插件：  
`/opt/rabbitmq/sbin/rabbitmqctl trace_on`

查看队列:  
`/opt/rabbitmq/sbin/rabbitmqctl list_queues`

创建用户:  
`/opt/rabbitmq/sbin/rabbitmqctl add_user test 123456`

设置test用户位管理员类型:  
`/opt/rabbitmq/sbin/rabbitmqctl set_user_tags test administrator`

浏览器上登录rabbitmq_management:  
`http://192.168.31.90:15672`

RabbitMQ的HTTP API接口:   
`curl -i -u test:123456 http://192.168.31.90:15672/api/vhosts`

参考资料:   
https://blog.csdn.net/qq_39135287/article/details/95725385
https://blog.csdn.net/weixin_39908106/article/details/110726274

RabbitMQ官网使用指导:  
https://www.rabbitmq.com/getstarted.html