package com.example.taxilink.EncryptionController.RSAEncryption;

import com.example.taxilink.EncryptionController.DataEncryption;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.Files.readAllLines;
import static java.nio.file.Files.walkFileTree;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RSA implements DataEncryption {
    private BigInteger prvKey;
    private BigInteger pubKey;
    private final Path keyFile = Paths.get("com/example/taxilink/EncryptionController/RSAEncryption/primes.txt");

    @Override
    public ArrayList<String> encrypt(ArrayList<String> data) {
        return null;
    }

    @Override
    public ArrayList<String> decrypt(ArrayList<String> data) {
        return null;
    }

    private ArrayList<String> formatData(String data) {
        return null;
    }

    private void generateKeys() throws IOException {
        long f_len = Files.lines(keyFile).count();
        List<String> primes = readAllLines(keyFile);
        int l1, l2;
        BigInteger prime1, prime2;
        l1 = randInt(0, (int) f_len);
        do {
            l2 = randInt(0, (int) f_len);
        }
        while (l2 == l1);
        prime1 = new BigInteger(primes.get(l1));
        prime2 = new BigInteger(primes.get(l2));

        BigInteger n = prime1.multiply(prime2);
        BigInteger fi = (prime1.subtract(BigInteger.valueOf(1))).multiply(prime2.subtract(BigInteger.valueOf(1)));
        long e = 2;
        long d = 2;
        while (!fi.gcd(BigInteger.valueOf(e)).equals(BigInteger.valueOf(1))) {
            e++;
        }
        pubKey = BigInteger.valueOf(e);
        while (!(fi.mod(BigInteger.valueOf(d * e))).equals(BigInteger.valueOf(1))) {
            d++;
        }
        prvKey = BigInteger.valueOf(d);
    }

    private int randInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, (max + 1));
    }

}

class Encoder {
    private:
    vector<int> prime;
    int pub;
    int prv;
    int n;

    void sieve_primes();

    void keys();

    int choose();

    vector<ll> rsa(const string &message);

    public:

    vector<string> encrypted(const vector<string> &info);
};

void Encoder::sieve_primes(){
        ll num_primes=50000;
        vector<bool> sieve(num_primes,true);
        sieve[0]=false;
        sieve[1]=false;
        int p=2;
        while(p*p<=num_primes){
        if(sieve[p]){
        for(int i=p*p;i<=num_primes;i+=p){
        sieve[i]=false;
        }
        }
        p+=1;
        }
        for(int i=0;i<sieve.size();i++){
        if(sieve[i])
        prime.push_back(i);
        }
        }

        int Encoder::choose(){
        srand(time(nullptr));
        auto k=rand()%prime.size();
        auto it=prime.begin();
        while(k--)
        it++;
        int ret=*it;
        prime.erase(it);
        return ret;
        }

        void Encoder::keys(){
        int prime1=choose(); // first prime number
        int prime2=choose(); // second prime number
        n=prime1*prime2;
        int fi=(prime1-1)*(prime2-1);
        int e=2;
        while(true){
        if(__gcd(e,fi)==1)
        break;
        e++;
        } // d = (k*Φ(n) + 1) / e for some integer k
        pub=e;
        int d=2;
        while(true){
        if((d*e)%fi==1)
        break;
        d++;
        }
        prv=d;
        }


// first converting each character to its ASCII value and
// then encoding it then decoding the number to get the
// ASCII and converting it to character
        vector<ll> Encoder::rsa(const string&message){
        vector<ll> form;
        // calling the encrypting function in encoding function
        for(auto&letter:message){
        int e=pub;
        ll encrypted_text=1;
        while(e--){
        encrypted_text*=(ll)letter;
        encrypted_text%=n;
        }
        form.push_back(encrypted_text);
        }
        return form;
        }


        vector<string> Encoder::encrypted(const vector<string> &info){
        sieve_primes();
        keys();
        vector<string> text;
        vector<vector<ll>>en;
        for(const auto&i:info){
        vector<ll> coded=rsa(i);
        en.push_back(coded);
        string x_str;
        for(auto&p:coded)
        x_str+=to_string(p);
        cout<<x_str<<"\n\n";
        text.push_back(x_str);
        }
        text.push_back(to_string(prv));
        cout<<prv<<endl;
        return text;
        }

        ll decrypt(int encrypted_text){
        int d=prv;
        ll decrypted=1;
        while(d--){
        decrypted*=encrypted_text;
        decrypted%=n;
        }
        return decrypted;
        }

        string decoder(const vector<int>&encoded){
        string s;
        // calling the decrypting function decoding function
        for(auto&num:encoded)
        s+=decrypt(num);
        return s;
        }
