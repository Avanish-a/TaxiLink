package com.example.taxilink.Database;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.taxilink.BaseEntity.Carpool;
import com.example.taxilink.BaseEntity.Request;
import com.example.taxilink.BaseEntity.User;
import com.example.taxilink.EncryptionController.DataEncryption;
import com.example.taxilink.EncryptionController.RSAEncryption.RSA;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class DatabaseHandler {
    private final DataEncryption encryption = new RSA();
    private final FirebaseFirestore db = FirebaseFirestore.getInstance();
    private final int idLim = 9999999;
    private final ArrayList<String> reqIDList = new ArrayList<>();
    private final ArrayList<String> carpoolIDList = new ArrayList<>();
    String TAG = "DatabaseHandler";

    private String generateReqID() {
        Random rand = new Random();
        String id;
        int lenLim = String.valueOf(idLim).length();
        do {
            id = String.valueOf(rand.nextInt(idLim) + 1);
            if (id.length() < lenLim) {
                id = "0".repeat(lenLim - id.length()) + id;
            }
            id = "R" + id;
        } while (reqIDList.contains(id));
        reqIDList.add(id);
        return id;
    }

    private String generateCarpoolID() {
        Random rand = new Random();
        String id;
        int lenLim = String.valueOf(idLim).length();
        do {
            id = String.valueOf(rand.nextInt(idLim) + 1);
            if (id.length() < lenLim) {
                id = "0".repeat(lenLim - id.length()) + id;
            }
            id = "C" + id;
        } while (carpoolIDList.contains(id));
        carpoolIDList.add(id);
        return id;
    }

    public void insert(String tableName, Object fieldInfo) {
        String id = "";
        if (Objects.equals(tableName, "Requests")) {
            id = generateReqID();
        } else if (Objects.equals(tableName, "Carpools")) {
            id = generateCarpoolID();
        }
        String docID = id;
        if (Objects.equals(tableName, "Users")) {
            db.collection(tableName).add(fieldInfo).addOnSuccessListener(aVoid -> Log.d(TAG, "Document" + " successfully updated!")).addOnFailureListener(e -> Log.w(TAG, "Error inserting document.", e));
        } else {
            db.collection(tableName).document(docID).set(fieldInfo).addOnSuccessListener(aVoid -> Log.d(TAG, "Document " + docID + " successfully updated!")).addOnFailureListener(e -> Log.w(TAG, "Error inserting document " + docID + "\n", e));
            HashMap<String, Object> idEntry = new HashMap<>();
            switch (tableName) {
                case "Carpools":
                    idEntry.put("carpoolID", docID);
                    db.collection(tableName).document(docID).set(idEntry, SetOptions.merge());
                    break;
                case "Requests":
                    idEntry.put("reqID", docID);
                    db.collection(tableName).document(docID).set(idEntry, SetOptions.merge());
                    break;
            }
        }
    }

    public void update(String tableName, String docID, String field, Object newVal) {
        db.collection(tableName).document(docID).update(field, newVal).addOnSuccessListener(aVoid -> Log.d(TAG, "Document " + docID + " successfully updated!")).addOnFailureListener(e -> Log.w(TAG, "Error updating document", e));
    }


    public ArrayList<Object> getRecords(String tableName, String condField, String condition) {
        ArrayList<Object> records = new ArrayList<>();
        db.collection(tableName).whereEqualTo("capital", true).get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                for (QueryDocumentSnapshot document : task.getResult()) {
                    Log.d(TAG, "Document " + document.getId() + "found!");
                }
            } else {
                Log.d(TAG, "Error getting documents: ", task.getException());
            }
        });
        return records;
    }


    public void readData(UserDataTest dataContainer) {
        ArrayList<String> a = new ArrayList<String>();
        db.collection("Users")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            ArrayList<String> userList = new ArrayList<>();

                            for (DocumentSnapshot doc : task.getResult()) {
                                a.add(doc.getId());
                                User u = doc.toObject(User.class);
                                assert u != null;
                            }
                            dataContainer.onCallback(userList);
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }

                });
    }

    public ArrayList<User> getUsers() {
        ArrayList<User> userRecords = new ArrayList<>();
        db.collection("Users").get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                for (QueryDocumentSnapshot document : task.getResult()) {
                    userRecords.add(document.toObject(User.class));
                    Log.d(TAG, "User " + document.getId() + " found!");
                }
            } else {
                Log.d(TAG, "Error getting documents: ", task.getException());
            }
        });
        return userRecords;
    }

    public ArrayList<Carpool> getCarpools() {
        ArrayList<Carpool> carpoolRecords = new ArrayList<>();
        db.collection("Carpools").get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                for (QueryDocumentSnapshot document : task.getResult()) {
                    carpoolRecords.add(document.toObject(Carpool.class));
                    Log.d(TAG, "Carpool " + document.getId() + " found!");
                }
            } else {
                Log.d(TAG, "Error getting documents: ", task.getException());
            }
        });
        return carpoolRecords;
    }

    public ArrayList<Request> getRequests() {
        ArrayList<Request> requestRecords = new ArrayList<>();
        db.collection("Requests").get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                for (QueryDocumentSnapshot document : task.getResult()) {
                    requestRecords.add(document.toObject(Request.class));
                    Log.d(TAG, "Request " + document.getId() + " found!");
                }
            } else {
                Log.d(TAG, "Error getting documents: ", task.getException());
            }
        });
        return requestRecords;
    }

    public void match(String destination) {
        db.collection("Carpools")
                .whereEqualTo("active", true).whereEqualTo("destination", destination)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            List<List<String>> check = new ArrayList<>();
                            QuerySnapshot docs = task.getResult();
                            for (QueryDocumentSnapshot document : docs) {
                                check.add((List<String>) document.get("members"));
                                Log.d("TAG", document.getId() + " => " + document.getData());
                            }
                            int a = 0;
                        } else {
                            Log.d("TAG", "Error getting documents: ", task.getException());
                        }
                    }
                });
    }

}
