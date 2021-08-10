pipeline {
    agent any
    tools {
        maven "maven3.8.1"
        jdk "jdk16"
    }
    stages {
        stage("Env Variables") {
            steps {
                sh "printenv"
            }
        }
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
        stage('Sonar'){
            
            steps{
                
                sh 'mvn verify org.sonarsource.scanner.maven:sonar-maven-plugin:sonar -Dsonar.projectKey=IvanMartinBlanco_proyecto1 -Dsonar.organization=ivanmartinblanco -Dsonar.host.url=https://sonarcloud.io -Dsonar.login=386c1d10fee2a4aef06d307f7df93e7dd9444d9a -Dsonar.branch.name=master'
            }

        }

    }
}
