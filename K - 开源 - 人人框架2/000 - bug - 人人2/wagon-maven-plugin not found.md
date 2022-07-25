bug

    Plugin 'org.codehaus.mojo:wagon-maven-plugin:1.0' not found

solve

    1、先添加依赖
    <dependency>
        <groupId>org.codehaus.mojo</groupId>
        <artifactId>wagon-maven-plugin</artifactId>
        <version>1.0</version>
    </dependency>

    2、再添加plugin
    <plugin>
				<groupId>org.codehaus.mojo</groupId>
				<artifactId>wagon-maven-plugin</artifactId>
				<version>1.0</version>
				<configuration>
					<fromFile>target/${pack-name}</fromFile>
					<url><![CDATA[scp://${remote-username}:${remote-passwd}@${remote-addr}${service-path}]]></url>
					<commands>
						<!-- Kill Old Process -->
						<command>kill -9 `ps -ef |grep ${project.artifactId}.jar|grep -v "grep" |awk '{print $2}'`</command>
						<!-- Restart jar package，write result into renren.log -->
						<command><![CDATA[nohup java -jar ${service-path}/${pack-name} --spring.profiles.active=test > ${service-path}/renren.log 2>&1 & ]]></command>
						<command><![CDATA[netstat -nptl]]></command>
						<command><![CDATA[ps -ef | grep java | grep -v grep]]></command>
					</commands>
					<!-- 运行命令 mvn clean package wagon:upload-single wagon:sshexec-->
					<displayCommandOutputs>true</displayCommandOutputs>
				</configuration>
			</plugin>

    