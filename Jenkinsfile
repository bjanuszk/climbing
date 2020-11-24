pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                withDockerContainer('openjdk:11') {
                    sh 'ls'
                    sh 'chmod 777 gradlew'
                    sh './gradlew clean build'
                }
            }
        }
    }

}
