pipeline{
    agent any 
    
    environment {
        JAVA_HOME = '/usr/lib/jvm/java-17-amazon-corretto'
        MAVEN_HOME = '/opt/maven'
    }

    stages {
        stage('checkout') {
            steps {
               git branch: 'Dev', url: 'https://github.com/prabhuhalakeri/Project-1.git', credentialsId: 'github_credentials'
            }
        }

        stage('build') {
            steps {
                script {
                    sh "${MAVEN_HOME}/bin/mvn clean install"
                }
            
            }
        }     
    }
}
