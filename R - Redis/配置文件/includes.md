### INCLUDES

### 描述


    # Include one or more other config files here.  This is useful if you
    # have a standard template that goes to all Redis servers but also need
    # to customize a few per-server settings.  Include files can include
    # other files, so use this wisely.

    在此处包含一个或多个其他配置文件。 
    这很有用，如果你有一个适用于所有 Redis 服务器的标准模板，但也需要自定义一些每个服务器的设置。 
    包含文件可以包含其他文件，因此请明智地使用它。

    #
    # Notice option "include" won't be rewritten by command "CONFIG REWRITE"
    # from admin or Redis Sentinel. Since Redis always uses the last processed
    # line as value of a configuration directive, you'd better put includes
    # at the beginning of this file to avoid overwriting config change at runtime.

    注意选项“include”不会被来自管理员或 Redis Sentinel的命令“CONFIG REWRITE”重写
    由于 Redis 总是使用最后处理的行作为配置指令的值，你最好把包括在此文件的开头，以避免在运行时覆盖配置更改。

    #
    # If instead you are interested in using includes to override configuration
    # options, it is better to use include as the last line.

    相反，如果您有兴趣使用包含来覆盖配置选项，最好使用包含作为最后一行。

    # include /path/to/local.conf
    # include /path/to/other.conf
