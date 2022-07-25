bug

    Plugin 'org.apache.maven.plugins:maven-surefire-plugin:' not found  

solve

            // 加上版本号即可
    		<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-surefire-plugin</artifactId>
				<configuration>
					<skipTests>true</skipTests>
				</configuration>
				<version>2.22.2</version>
			</plugin>