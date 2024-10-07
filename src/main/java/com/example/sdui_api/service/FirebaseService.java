package com.example.sdui_api.service;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import org.springframework.stereotype.Service;
import java.util.List;



@Service
public class FirebaseService {

    public void writeData(String node, Object data) {
        // Get a reference to the Firebase Database node
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference(node);
        // Write the data to the specified node
        databaseReference.setValueAsync(data);
    }


    public CompletableFuture<List<Object>> readData(String node) {
        CompletableFuture<List<Object>> futureData = new CompletableFuture<>();

        // Get a reference to the Firebase Database node
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference(node);

        // Attach a listener to retrieve the data
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Object> resultData = new ArrayList<>();

                // Check if there is data at the specified node
                if (dataSnapshot.exists()) {
                    // Iterate through the children of the node
                    for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
                        Object value = childSnapshot.getValue();
                        if (value != null) {
                            resultData.add(value);  // Add only the value to the list
                        }
                    }
                    futureData.complete(resultData);  // Complete the future with the result data
                } else {
                    futureData.complete(new ArrayList<>());  // Return an empty list if no data found
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                System.err.println("Error reading data from Firebase: " + error.getMessage());
                futureData.completeExceptionally(error.toException());  // Complete with error
            }
        });

        return futureData;  // Return the future
    }
    
    // public CompletableFuture<Map<String, Object>> readData(String node) {
    //     // Create a CompletableFuture to return the data asynchronously
    //     CompletableFuture<Map<String, Object>> futureData = new CompletableFuture<>();

    //     // Get a reference to the Firebase Database node
    //     DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference(node);

    //     // Attach a listener to retrieve the data
    //     databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
    //         @Override
    //         public void onDataChange(DataSnapshot dataSnapshot) {
    //             Map<String, Object> resultData = new HashMap<>();

    //             // Check if there is data at the specified node
    //             if (dataSnapshot.exists()) {
    //                 // Iterate through the children of the node
    //                 for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
    //                     // Get the key and value for each child
    //                     String key = childSnapshot.getKey();
    //                     Object value = childSnapshot.getValue();
    //                     resultData.put(key, value);  // Add to the result map
    //                 }
    //                 futureData.complete(resultData);  // Complete the future with the result data
    //             } else {
    //                 futureData.complete(null);  // No data found
    //             }
    //         }

    //         @Override
    //         public void onCancelled(DatabaseError error) {
    //             System.err.println("Error reading data from Firebase: " + error.getMessage());
    //             futureData.completeExceptionally(error.toException());  // Complete with error
    //         }
    //     });

    //     return futureData;  // Return the future
    // }
    
    
    // public void readData(String node) {
    //     // Get a reference to the Firebase Database node
    //     DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference(node);

    //     // Attach a listener to retrieve the data
    //     databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
    //         @Override
    //         public void onDataChange(DataSnapshot dataSnapshot) {
    //             Object data = dataSnapshot.getValue();
    //             System.out.println("Data from Firebase: " + data);
    //         }

    //         @Override
    //         public void onCancelled(DatabaseError error) {
    //             System.err.println("Error reading data from Firebase: " + error.getMessage());
    //         }
    //     });
    // }


}
