FROM openjdk:21
WORKDIR /workdir

ARG MAVEN_VERSION=3.9.2
ARG BASE_URL=https://archive.apache.org/dist/maven/maven-3/${MAVEN_VERSION}/binaries

RUN curl -fsSL -o maven.tar.gz ${BASE_URL}/apache-maven-${MAVEN_VERSION}-bin.tar.gz \
    && tar -xzf maven.tar.gz -C /workdir \
    && ln -s /workdir/apache-maven-${MAVEN_VERSION} /workdir/maven \
    && rm maven.tar.gz

ENV MAVEN_HOME /workdir/maven
ENV PATH $MAVEN_HOME/bin:$PATH

RUN mkdir app
ADD src app/src/
ADD mvnw app/mvnw
ADD mvnw.cmd app/mvnw.cmd
ADD pom.xml app/pom.xml                                                                                                               

RUN mvn -version
EXPOSE 8080
CMD ["tail", "-f", "/dev/null"]
