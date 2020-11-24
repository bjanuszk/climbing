pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                withDockerContainer('openjdk:11') {
                    sh 'ls'
                    sh 'pwd'
                    sh 'gradlew clean build'
                }
            }
        }
    }

}
