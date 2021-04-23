pipeline {
    agent any
    environment {
        GLOBAL = "glob"
    }
    stages {
        stage('Build') {
            environment {
                STAGE_SPEC = "stage spec"
            }
            steps {
                withDockerContainer('7factor/terraform-resource:latest') {
                    sh 'terraform version'
                    dir("ops") {
                        sh 'terraform init'
                        sh 'terraform plan -no-color -detailed-exitcode && (echo "No changes $?" && echo "foo") || (echo "Changes detected $?" && echo "bar")'
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
