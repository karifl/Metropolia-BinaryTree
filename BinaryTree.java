/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package btree;





/**
 *
 * 
 */
public class BinaryTree {

    private Node root;
    public static BinaryTree found;
 
    public BinaryTree(String rootValue) {
        root = new Node(rootValue);
    }
    public BinaryTree(){
        root = null;
    }
    /*public BinaryTree(String rootValue, BinaryTree left, BinaryTree right){
        root = new Node(rootValue, left, right);
    } */
    
    public void insert(String aData){
       Node inNode = new Node(aData);
       
       if (root == null) {
    	   root = inNode;

       }
       
       
       else if(root.getData().compareTo(aData) < 0) {
    	   if(root.left()!= null) { 
    		   root.left().insert(aData); //jatketaan vasempaan   
    	   } else {
    		   root.setLeft(new BinaryTree(aData)); // asetetaan node binääripuu
    	   }
       }
       
       
       
    	else if(root.getData().compareTo(aData) > 0) {
    		if(root.right()!= null) {
    			root.right().insert(aData); //jatketaan oikeaan
    		} else {
    			root.setRight(new BinaryTree(aData)); // asetetaan node binääripuu
    		}
    	   
       } else {
            System.out.println("ERROR: value exists already.");
       }
    }
     

    
    public BinaryTree find(String aData){
             //   Node vasen = new Node("malli"); 
             //   vasen = root.left().root;
             //    Node oikea = new Node("malli");
             //      oikea = root.right().root;
                   
    	if(root==null ||root.getData().equals(aData)) {
                    System.out.println("Nykyinen sijainti: "+root.getData());     		
                    return this; //palauttaa nykyisen sijainnin.
        }
 
                
             else if(root.getData().compareTo(aData) < 0){
                  if(root.left()!= null) {
                        System.out.println("Solmu: " + root.getData());  
                        System.out.println("Vasempaan..");
                        return root.left().find(aData);
                  } else{
                      System.out.println("Vasemmassa lehdessä ollaan: "+ root.getData());
                      return null;
                  }
                  
              } else {
                    if(root.right()!=null){
                         System.out.println("Solmu: " + root.getData());
                         System.out.println("Oikeaan..");
                        return root.right().find(aData);
                     
                    }else{
                         return null;
                    }

                  
              }
                   

    }
    
    
    
    public void preOrder() {
        if (root != null) {
            System.out.println(root.getData()+',');
            if (root.left() != null) // pääseeekö vasemmalle?
                root.left().preOrder();
            if (root.right() != null) // pääseekö oikealle?
                root.right().preOrder();
        }

    }

  
    public void setLeft(BinaryTree tree) {
        root.setLeft(tree);
    }

    public void setRight(BinaryTree tree) {
        root.setRight(tree);
    }
    
    
}
