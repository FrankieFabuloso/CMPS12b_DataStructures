//-----------------------------------------------------------------------------
//   IntegerStack.c
//   Implementation file for IntegerStack ADT
//-----------------------------------------------------------------------------

#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<assert.h>
#include"Dictionary.h"


// private types --------------------------------------------------------------

// NodeObj
typedef struct NodeObj{
   char* key;
   char* value;
   struct NodeObj* next;
} NodeObj;

// Node
typedef NodeObj* Node;

// newNode()
// constructor of the Node type
Node newNode(char* x, char* y) {
   Node N = malloc(sizeof(NodeObj));
   assert(N!=NULL);
   N->key = x;
   N->value = y;
   N->next = NULL;
   return(N);
}

// freeNode()
// destructor for the Node type
void freeNode(Node* pN){
   if( pN!=NULL && *pN!=NULL ){
      free(*pN);
      *pN = NULL;
   }
}


// DictionaryObj
typedef struct DictionaryObj{
   Node top;
   int numItems;
} DictionaryObj;


// public functions -----------------------------------------------------------


//findKey()
//retruns a node with a specific key
Node findKey(Dictionary D, char* key){
   if( D==NULL ){
   fprintf(stderr, 
           "Dictionary Error: calling isEmpty() on NULL Dictionary reference\n");
   exit(EXIT_FAILURE);
   }
   Node N = D->top;
  // printf("%s, %s \n",N->key, key);
   while(strcmp(N->key, key)){
      N = N->next;
	  // printf("%s, %s \n",N->key, key);
   }
   return N;
}



// newDictionary()
// constructor for the Dictionary type
Dictionary newDictionary(void){
   Dictionary D = malloc(sizeof(DictionaryObj));
   assert(D!=NULL);
   D->top = NULL;
   D->numItems = 0;
   return D;
}

// freeDictionary()
// destructor for the Dictionary type
void freeDictionary(Dictionary* pD){
   if( pD!=NULL && *pD!=NULL ){
      if( !isEmpty(*pD) ) makeEmpty(*pD); //empty the Dictionary
      free(*pD);
      *pD = NULL;
   }
}

// isEmpty()
// returns 1 (true) if S is empty, 0 (false) otherwise
// pre: none
int isEmpty(Dictionary D){
   if( D==NULL ){
      fprintf(stderr, 
              "Dictionary Error: calling isEmpty() on NULL Dictionary reference\n");
      exit(EXIT_FAILURE);
   }
   return(D->numItems==0);
}

// size()
// returns the number of (key, value) pairs in D
// pre: none
int size(Dictionary D){
   if( D==NULL ){
      fprintf(stderr, 
              "Dictionary Error: calling size() on NULL Dictionary reference\n");
      exit(EXIT_FAILURE);
   }
   return (D->numItems);
}
// lookup()
// returns the value v such that (k, v) is in D, or returns NULL if no 
// such value v exists.
// pre: none
char* lookup(Dictionary D, char* k){
if( D==NULL ){
      fprintf(stderr, 
              "Dictionary Error: calling lookup() on NULL Dictionary reference\n");
      exit(EXIT_FAILURE);
   }
Node N;
char* val=NULL;
	for(N=D->top; N!=NULL; N=N->next)
	if(!strcmp(k, N->key)) val = N->value;
return val;
}
// insert()
// pushes x onto top of S
// pre: none
void insert(Dictionary D, char* x, char* y){
	if(lookup(D, x) != NULL ){
      fprintf(stderr, "Ditionary Error: Key Collison exception\n");
      exit(EXIT_FAILURE);
   }
	
   Node N;
   Node T;
   if( D==NULL ){
      fprintf(stderr, "Dictionary Error: calling push() on NULL Dictionary reference\n");
      exit(EXIT_FAILURE);
   }
	N = newNode(x,y);
	T = D->top;
	if(T == NULL){
	D->top=N;
	}else{
	while(T->next != NULL){
	T = T->next;
		}
	T->next = N;
	}
	D->numItems++;
}
// delete()
// deletes and returns item at top of D
// pre: !isEmpty(S)
void delete(Dictionary D, char* k){
   Node N;
   Node T;
   if( D==NULL || lookup(D, k)== NULL ){
      fprintf(stderr, "Dictionary Error: calling delete() on NULL Dictionary reference\n");
      exit(EXIT_FAILURE);
   }
   if( D->numItems==0 ){
      fprintf(stderr, "Dictionary Error: calling delete() on empty Dictionary\n");
      exit(EXIT_FAILURE);
   }
	N = findKey(D, k);
	T = D->top;
	if(T == N){
	D->top = D->top->next;
	}else{
		while(T->next !=N){
		T = T->next;
		}
	T->next = N->next;
	}
	D->numItems--;
	freeNode(&N);
}


void pop(Dictionary D){
   Node N;
   if( D==NULL ){
      fprintf(stderr, "Dictionary Error: calling pop() on NULL Dictionary reference\n");
      exit(EXIT_FAILURE);
   }
   if( D->numItems==0 ){
      fprintf(stderr, "Dictionary Error: calling pop() on empty Dictionary\n");
      exit(EXIT_FAILURE);
   }
   N = D->top;
   D->top = D->top->next;
   D->numItems--;
   freeNode(&N);
}



// makeEmpty()
// re-sets D to the empty state.
// pre: none
void makeEmpty(Dictionary D){
 if( D==NULL){
      fprintf(stderr, "Dictionary Error: calling delete() on NULL Dictionary reference\n");
      exit(EXIT_FAILURE);
	  }  
     Node N;
   while( D->numItems>0 ){  
      N = D->top;
      D->top = D->top->next;
      D->numItems--;
      freeNode(&N);
   } 
}	

// printDictionary()
// prints a text representation of S to the file pointed to by out
// pre: none
void printDictionary(FILE* out, Dictionary D){
   Node N;
   if( D==NULL ){
      fprintf(stderr, 
              "Dictionary Error: calling printDictionary() on NULL Dictionary reference\n");
      exit(EXIT_FAILURE);
   }
   for(N=D->top; N!=NULL; N=N->next) fprintf(out, "%s %s \n", N->key, N->value);
}

