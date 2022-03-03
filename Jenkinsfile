pipeline{
	
	agent any
	
	tools {
        maven "My_MAVEN"
        jdk "JDK"
    }
  
  stages{
		stage("Clean and Build"){
		steps{
			script{
			sh 'mvn clean install'
			}
		}
		}
		stage("Execute Tests"){
		steps{
			script{
			sh 'mvn test'
			}
		}
		}
		stage("Reporting"){
		steps{
		publishHTML (target : [allowMissing: false,
 alwaysLinkToLastBuild: true,
 keepAll: true,
 reportDir: 'ExtentReports',
 reportFiles: '*.html',
 reportName: 'Extent Reports',
 reportTitles: 'Extent Report'])
		}	
}}}