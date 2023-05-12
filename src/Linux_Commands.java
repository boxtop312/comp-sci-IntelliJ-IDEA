import java.util.Scanner;
import java.util.*;
class Linux_Commands {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static void main(String[] args) {
        FileSystemTree fileSystemTree = new FileSystemTree();
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        while (isRunning) {
            System.out.print(ANSI_GREEN + "$ " + ANSI_RESET);
            String command = scanner.nextLine();
            String[] commandParts = command.split(" ");
            switch (commandParts[0]) {
                case "exit":
                    isRunning = false;
                    System.out.println("Goodbye!");
                    break;
                    case "ls":
                        fileSystemTree.listFiles();
                        break;
                    case "cd":
                        if (commandParts.length >= 2) {
                            fileSystemTree.changeDirectory(commandParts[1]);
                        }
                        break;
                    case "mkdir":
                        if (commandParts.length >= 2) {
                            fileSystemTree.makeDirectory(commandParts[1]);
                        } else {
                            System.out.println("Invalid usage: provide name");
                        }
                        break;
                    case "touch":
                        if (commandParts.length >= 2) {
                            fileSystemTree.makeFile(commandParts[1]);
                        } else {
                            System.out.println("Invalid usage: provide name");
                        }
                        break;
                    default:
                        System.out.println("Invalid command.");
                        break;
            }
        }
    }
}

class FileSystemTree {
    public static LNode root;
    public LNode currentDir;

    public FileSystemTree() {
        // create root named "/"
        // set current to root
        root=new LNode("/",true);
        root.parent=root;
        currentDir=root;
        root.addChild(new LNode("home",true));

    }
    // abs example "/home/folder1/folder2"
    //reletive example "./folder1/folder2" or "folder1/folder2"
    // parent example "../folder1/folder2"

    // start from root /
    // start from current directory ./ or no / es at all
    // start from current directory's parent ../

    public void changeDirectory(String path) {
        // change current dir
        //make sure you can process both reletive and abs paths
        // split path by "/"
        //make sure path is valid
        if(!path.contains("/")){
            ArrayList<String> names = new ArrayList<String>();
            for (LNode c: currentDir.children) {
                names.add(c.name);
            }
            if(!names.contains(path)){
                System.out.println("Invalid Path");
            }else{
                for (int i = 0; i < currentDir.children.size(); i++) {
                    if(Objects.equals(currentDir.children.get(i).name, path)){
                        currentDir=currentDir.children.get(i);
                    }
                }
            }
        } else{
            char[] Cpath = path.toCharArray();
            String[] splitPath = path.split("/");
            if(Cpath[0]=='.'&&Cpath[1]=='/'){
                for (int i = 0; i < currentDir.children.size(); i++) {
                    if(Objects.equals(currentDir.children.get(i).name, splitPath[1])){
                        currentDir=currentDir.children.get(i);
                    }
                }
                if(splitPath.length>2&&splitPath[2]!=null){
                    for (int i = 0; i < currentDir.children.size(); i++) {
                        if(Objects.equals(currentDir.children.get(i).name, splitPath[2])){
                            currentDir=currentDir.children.get(i);
                        }
                    }
                }
            } else if (Cpath[0]=='.'&&Cpath[1]=='.'&&Cpath[2]=='/') {
                currentDir=currentDir.parent;
                if(splitPath.length>1){
                    for (int i = 0; i < currentDir.children.size(); i++) {
                        if(Objects.equals(currentDir.children.get(i).name, splitPath[1])){
                            currentDir=currentDir.children.get(i);
                        }
                    }
                    if(splitPath.length>2&&splitPath[2]!=null){
                        for (int i = 0; i < currentDir.children.size(); i++) {
                            if(Objects.equals(currentDir.children.get(i).name, splitPath[2])){
                                currentDir=currentDir.children.get(i);
                            }
                        }
                    }
                    for (int i = 1; i < splitPath.length; i++) {
                        if(Objects.equals(splitPath[i], "..")){
                            currentDir=currentDir.parent;
                        }
                    }
                }

            } else if (Cpath[0]=='/'){
                if(Cpath.length==1){
                    currentDir=root;
                } else {
                    currentDir=root;
                    if(splitPath.length>1){
                        for (int i = 0; i < currentDir.children.size(); i++) {
                            if(Objects.equals(currentDir.children.get(i).name, splitPath[1])){
                                currentDir=currentDir.children.get(i);
                            }
                        }
                        if(splitPath.length>2&&splitPath[2]!=null){
                            for (int i = 0; i < currentDir.children.size(); i++) {
                                if(Objects.equals(currentDir.children.get(i).name, splitPath[2])){
                                    currentDir=currentDir.children.get(i);
                                }
                            }
                        }
                    }
                }
            }

        }
        if(!currentDir.isDirectory){
            currentDir=root;
            System.out.println("You can't cd into a file");
        }

    }

    public void listFiles() {
        //list childern
        ArrayList<String> names = new ArrayList<String>();
        if(currentDir != root && currentDir.parent == root) {
            System.out.print(currentDir.parent.name);
            System.out.println(currentDir.name);
        } else if(currentDir!=root&&currentDir.parent.parent==root) {
            System.out.print(currentDir.parent.parent.name);
            System.out.print(currentDir.parent.name+"/");
            System.out.println(currentDir.name);
        } else if(currentDir!=root&&currentDir.parent.parent.parent==root) {
            System.out.print(currentDir.parent.parent.parent.name);
            System.out.print(currentDir.parent.parent.name+"/");
            System.out.print(currentDir.parent.name+"/");
            System.out.println(currentDir.name);
        } else{
            System.out.println(currentDir.name);
        }
        for (LNode c: currentDir.children) {
            names.add(c.name);
        }
        for (String n:names) {
            System.out.println(n);
        }
    }

    public void makeFile(String name) {
        //add child file to current
        currentDir.addChild(new LNode(name, currentDir));
    }

    public void makeDirectory(String name) {
        //add child dir to current
        currentDir.addChild(new LNode(name, currentDir,true));
    }
}

class LNode {
    LNode(String n, LNode p){
        name = n;
        parent=p;
        isDirectory = false;
    }
    LNode(String n, LNode p, boolean b){
        name = n;
        parent=p;
        isDirectory = b;
    }
    LNode(String n){
        name = n;
        parent = FileSystemTree.root;
        isDirectory = false;
    }
    LNode(String n, boolean b){
        name = n;
        parent = FileSystemTree.root;
        isDirectory = b;
    }
    void addChild(LNode c){
        children.add(c);
    }
    void removeChild(LNode c){
        for(int i=0;i<children.size();i++){
            if(children.get(i)==c&&c.isDirectory){
                children.remove(i);
                break;
            }
        }
    }
    void setParent(LNode c, LNode p){
        c.parent=p;
    }
    ArrayList<LNode> children = new ArrayList<LNode>();
    LNode parent;
    String name;
    boolean isDirectory;
}

// in file system trer class
//LNode root
//root.parent = root
