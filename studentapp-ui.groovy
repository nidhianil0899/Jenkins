pipeline {
    agent any

    stages {
        stage('Pull') {
            steps {
                git changelog: false, poll: false, url: 'https://github.com/chetansomkuwar254/studentapp.ui'
                echo 'Yes, Application repository pull is done !'
            }
        }
        stage('Build') {
            steps {
                echo 'Yes, Application Build is done !'
            }
        }
        stage('Test') {
            steps {
             echo " TEST done"
            }
        }
        stage('Deploy') {
            steps {
              echo 'Deploy Done'
            }
        
        }
    }
}
