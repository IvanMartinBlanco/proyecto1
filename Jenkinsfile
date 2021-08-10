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
                
                sh 'mvn verify sonar:sonar -Dsonar.projectKey=IvanMartinBlanco_m3-maven-clase -Dsonar.organization=ivanmartinblanco -Dsonar.host.url=https://sonarcloud.io -Dsonar.login=2b0517953686442777fc4ca60fc0397821c643ae -Dsonar.branch.name=master'
            }

        }

    }
}
