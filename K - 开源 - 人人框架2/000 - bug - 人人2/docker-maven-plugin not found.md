bug

    Plugin 'com.spotify:docker-maven-plugin:0.4.14' not found

solve

    1、添加依赖
    <dependency>
        <groupId>com.spotify</groupId>
        <artifactId>docker-maven-plugin</artifactId>
        <version>1.2.2</version>
    </dependency>

    2、再添加plugin
    <plugin>
				<groupId>com.spotify</groupId>
				<artifactId>docker-maven-plugin</artifactId>
				<version>0.4.14</version>
				<configuration>
					<imageName>renren/fast</imageName>
					<dockerDirectory>${project.basedir}</dockerDirectory>
					<resources>
						<resource>
							<targetPath>/</targetPath>
							<directory>${project.build.directory}</directory>
							<include>${project.build.finalName}.jar</include>
						</resource>
					</resources>
				</configuration>
				<!-- 运行命令 mvn clean package docker:build 打包并生成docker镜像 -->
			</plugin>