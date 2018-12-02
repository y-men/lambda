FROM centos
RUN yum install -y java
VOLUME /tml
ADD ../voute/build/libs/voute-0.0.1-SNAPSHOT.jar voute.jar
ADD /run.sh run.sh
RUN sh -c 'touch /voute.jar
RUN sh -c 'touch /run.sh

EXPOSE 8081
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/voute.jar"]
ENTRYPOINT ["/run.sh"]