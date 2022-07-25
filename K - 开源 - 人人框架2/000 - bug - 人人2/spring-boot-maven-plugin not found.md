bug

    Plugin 'org.springframework.boot:spring-boot-maven-plugin:' not found

solve: 添加版本号

			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
				<configuration>
					<fork>true</fork>
				</configuration>
				<version>2.6.6</version>
			</plugin>

    