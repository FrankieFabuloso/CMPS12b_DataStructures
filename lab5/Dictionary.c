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
Node findKey(Dictionary D, char* k){
   if( D==NULL ){
   fprintf(stderr, 
           "Dictionary Error: calling isEmpty() on NULL Dictionary reference\n");
   exit(EXIT_FAILURE);
   }

   Node N = D->top;
   while(strcmp(N->key, k)){
      N = N->next;
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
   f( D==NULL ){
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
char* val = NULL;
for(N=D->top; N!=NULL; N=N->next)
   if(strcmp(N->key, k)) val = N->value;
return val;
}

// push()
// pushes x onto top of S
// pre: none
void insert(Dictionary D, char* x, char* y){
   Node N;
   if( D==NULL ){
      fprintf(stderr, "Stack Error: calling push() on NULL Stack reference\n");
      exit(EXIT_FAILURE);
   }
   N = newNode(x,y);
   N->next = D->top;
   D->top = N;
   D->numItems++;
}

// delete()
// deletes and returns item at top of D
// pre: !isEmpty(S)
void delete(Stack S, char* k){
   int returnValue;
   Node curr;
   Node N;
   if( S==NULL ){
      fprintf(stderr, "Stack Error: calling delete() on NULL Dictionary reference\n");
      exit(EXIT_FAILURE);
   }
   if( S->numItems==0 ){
      fprintf(stderr, "Stack Error: calling delete() on empty Dictionary\n");
      exit(EXIT_FAILURE);
   }

   N = D->top;
   returnValue = D->top->item;
   D->top = D->top->next;
   D->numItems--;
   freeNode(&N);
   return returnValue;
}


// makeEmpty()
// re-sets D to the empty state.
// pre: none
void makeEmpty(Dictionary D){
   D->top = NULL;
   D->numItems = 0;
   freeNode(&D);
}

// printStack()
// prints a text representation of S to the file pointed to by out
// pre: none
void printStack(FILE* out, Dictionary D){
   Node N;
   if( D==NULL ){
      fprintf(stderr, 
              "Stack Error: calling printStack() on NULL Stack reference\n");
      exit(EXIT_FAILURE);
   }
   for(N=D->top; N!=NULL; N=N->next) fprintf(out, "%d ", N->item);
   fprintf(out, "\n");
}

