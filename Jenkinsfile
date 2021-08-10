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
                
                sh 'mvn verify org.sonarsource.scanner.maven:sonar-maven-plugin:sonar -Dsonar.projectKey=IvanMartinBlanco_proyecto1 -Dsonar.organization=ivanmartinblanco -Dsonar.host.url=https://sonarcloud.io -Dsonar.login=ad1c1d1204a44e8e8c25c81d6eebb903437a2b76 -Dsonar.branch.name=master'
            }

        }

    }
}
