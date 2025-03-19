# Usando uma imagem base do OpenJDK
FROM openjdk:22

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o JAR gerado para dentro do container
COPY target/GestaoEstoque2025-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta 8082 (ou a porta que você deseja usar)
EXPOSE 8082

# Define o comando de inicialização do container
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
