//-----------------------------------------------------------------------------
// DictionaryClient.c
// Test client for the Dictionary ADT
//-----------------------------------------------------------------------------

#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include"Dictionary.h"

#define MAX_LEN 180

int main(int argc, char* argv[]){
   Dictionary A = newDictionary();
   char* k;
   char* v;
   char* word1[] = {"1","2","3","4","5","6","7", "8","9","x"};
   char* word2[] = {"11111","22222","333","444","555","666666","777","888 88","99","xxx"};
   int i;

   for(i=0; i<10; i++){
      insert(A, word1[i], word2[i]);
   }

   printDictionary(stdout, A);

   for(i=0; i<10; i++){
      k = word1[i];
      v = lookup(A, k);
      printf("key=\"%s\" %s\"%s\"\n", k, (v==NULL?"not found ":"value="), v);
   }



   delete(A, "1");
   delete(A, "2");
   delete(A, "8");
	delete(A, "9");
	delete(A, "x");
	delete(A, "7");
   printDictionary(stdout, A);

   
	insert(A, "1", "glow");
   insert(A, "x", "mom");
   
   for(i=0; i<10; i++){
      k = word1[i];
      v = lookup(A, k);
      printf("key=\"%s\" %s\"%s\"\n", k, (v==NULL?"not found ":"value="), v);
   }

  // delete(A, "one");  // error: key not found

   printf("%s\n", (isEmpty(A)?"true":"false"));
   printf("%d\n", size(A));
   makeEmpty(A);
   //makeEmpty(B);
   printf("%s\n", (isEmpty(A)?"true":"false"));

   freeDictionary(&A);

   return(EXIT_SUCCESS);
}
