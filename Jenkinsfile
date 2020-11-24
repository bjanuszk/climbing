pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                withDockerContainer('openjdk:11') {
                    sh 'gradlew clean build'
                }
            }
        }
    }

}
