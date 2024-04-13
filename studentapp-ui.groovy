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
                sh '/opt/apache-maven-3.9.6/bin/mvn clean package'
                echo 'Yes, Application Build is done !'
            }
        }
        stage('Test') {
            steps {
                sh ''' /opt/apache-maven-3.9.6/bin/mvn sonar:sonar \
                    -Dsonar.projectKey=studentapp \
                    -Dsonar.host.url=http://13.234.113.210:9000 \
                    -Dsonar.login=b768cf437c9df666c394d7496a12eab586f468e9 '''
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
