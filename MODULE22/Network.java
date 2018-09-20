import java.util.Arrays;
class NetworkUser{

    String nameuser;
    String[] list1 = new String[100];
    int res = 0;
    public NetworkUser(String name,String[] list1){
        nameuser = name;
        for(String n:list1){
            addfr(n);
        }
    }
    public String getName(){
        return nameuser;
    }
    public String[] list() {
        return list1;
    }
    public int listlength(){
        return res;
    }
    public void addfr(String friend) {
        friend = friend.replace(".","").trim();
        list1[res] = friend;
        res++; 
    }
    public String tostring() {
        String s = "[";
        for(int i = 0; i < res-1; i++) {
            s = s + list1[i] + ", ";
        }
        return s + list1[res-1] + "]";
    }
}



class Network{
    public String[] list1,list2;
    NetworkUser[] user;
    int size;
    Network() {
        user = new NetworkUser[100];
        size = 0;
    }
    public void getconn(String name) {
        if(size!=0) {
            int f = 0;
            for(int i = 0; i < size; i++) {
                if(name.equals(user[i].getName())) {
                    f = 1;
                    System.out.println(user[i].tostring());
                }
            }
            if(f == 0) {
                System.out.println("Not a user in Network");
            }
        }
    }
    public void addconn(String name, String newfr) {
        for(int i = 0; i < size; i++) {
            if(name.equals(user[i].getName())) {
                user[i].addfr(newfr);
            }
        }
    }

    public void person(String username, String fr) {
        String[] list12 = fr.split(",");
        NetworkUser u = new NetworkUser(username,list12);
        user[size++] = u;
        int n = 0;
        if(size>2){
        while(n<size) {
            for(int i = 0; i < size - 1; i++) {
                if(user[i].nameuser.compareTo(user[i+1].nameuser)>0){
                    NetworkUser t = user[i];
                    user[i] = user[i+1];
                    user[i+1] = t;
                }
            }
        n++;    
        }
        }
    }
    public String getsimilarconn(String name1, String name2) {
        String[] cmnFrnd;
        for(int i = 0; i < size; i++) {
            if(name1.equals(user[i].getName())){
                list1 = Arrays.copyOf(user[i].list(),user[i].listlength());
            }
            if(name2.equals(user[i].getName())){
                list2 = Arrays.copyOf(user[i].list(),user[i].listlength());
            }
        }
        if(list1.length > list2.length) {
            cmnFrnd = new String[list1.length];
        }else{
            cmnFrnd = new String[list2.length];
        }
        int temp = 0;
        if(list1.length !=0 && list2.length != 0) {
            for(int j = 0; j < list1.length; j++) {
                for(int k = 0; k < list2.length; k++) {
                    if(list1[j].equals(list2[k])){
                        cmnFrnd[temp++] = list1[j]; 
                    }
                    else{
                        continue;
                    }
                }
            }
        }
        if(temp == 0) {
            return "[]";
        }
        String str = "[";
        for(int i = 0; i < temp-1; i++) {
            str = str + cmnFrnd[i] + ", ";
        }
        return str + cmnFrnd[temp-1] + "]";
    }
    public void network() {
        String str = "";
        for(int i = 0; i < size-1; i++) {
            str = str + user[i].getName()+": "+user[i].tostring()+", ";
        }str = str + user[size-1].getName()+": "+user[size-1].tostring();
        System.out.println(str);
    }
}




