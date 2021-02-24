pipeline{
	agent any
    tools { 
        maven 'MAVEN' 
        jdk 'jdk8' 
    }	
	stages {
		stage('Build'){
			steps{
				bat 'mvn clean install -DskipTests'
			}
		}
	}
}
		