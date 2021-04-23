pipeline {
    agent any
    environment {
        GLOBAL = "glob"
    }
    stages {
        stage('Build') {
            steps {
                withDockerContainer('7factor/terraform-resource:latest') {
                    script {
                        sh 'terraform version'
                        dir("ops") {
                            sh 'terraform init'
                            env.INFRA_CHANGES_DETECTED = "abc"
                            sh 'printenv'
                            sh 'terraform plan -no-color -detailed-exitcode && echo "No changes $?" || (echo "Changes detected $?" && export INFRA_CHANGES_DETECTED2="true")'
                            sh 'printenv'
                        }
                        timeout(time: 30, unit: 'SECONDS') {
                            sh 'echo Users allowed to approve: ${TERRAFORM_APPROVERS}'
                            input message: 'Approve deployment?', submitter: "${TERRAFORM_APPROVERS}"
                        }
                        dir("ops") {
                            sh 'terraform apply -auto-approve'
                            sh 'cat ./myfile.txt'
                        }
                    }
                }
            }
        }
    }
}
