
class GenerateDeployment {
    static final String FILE_NAME = "deploy";
    static void main(String[] args) {

        int resources = 40
        File outFile = new File("${FILE_NAME}-${resources}.yaml")

        StringBuilder sb = new StringBuilder()
        for (int i=1;i<=resources;i++) {
            sb.append("apiVersion: apps/v1").append("\n")
            sb.append("kind: Deployment").append("\n")
            sb.append("metadata:").append("\n")
            sb.append("  name: nginx-deployment${i}").append("\n")
            sb.append("  labels:").append("\n")
            sb.append("    app: nginx${i}").append("\n")
            sb.append("spec:").append("\n")
            sb.append("  replicas: 1").append("\n")
            sb.append("  selector:").append("\n")
            sb.append("    matchLabels:").append("\n")
            sb.append("          app: nginx${i}").append("\n")
            sb.append("  template:").append("\n")
            sb.append("    metadata:").append("\n")
            sb.append("      labels:").append("\n")
            sb.append("        app: nginx${i}").append("\n")
            sb.append("    spec:").append("\n")
            sb.append("      containers:").append("\n")
            sb.append("      - name: nginx").append("\n")
            sb.append("        image: nginx:1.20.2").append("\n")
            sb.append("        resources:").append("\n")
            sb.append("          limits:").append("\n")
            sb.append("            memory: \"10Mi\"").append("\n")
            sb.append("        ports:").append("\n")
            sb.append("        - containerPort: 80").append("\n")
            sb.append("\n\n---\n")

        }

        outFile.write(sb.toString())
        println("yaml created with ${resources} resources !!")
    }

}
