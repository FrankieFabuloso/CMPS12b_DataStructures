//-----------------------------------------------------------------------------
// List.h
// Header file for the List ADT
//-----------------------------------------------------------------------------

#ifndef _LIST_H_INCLUDE_
#define _LIST_H_INCLUDE_


// List
// Exported reference type
typedef struct ListObj* List;

// newList()
// constructor for the List type
List newList(void);

// freeList()
// destructor for the List type
void freeList(List* pL);

// isEmpty()
// returns 1 (true) if S is empty, 0 (false) otherwise
// pre: none
int isEmpty(List L);

// size()
// returns the number of (key, value) pairs in D
// pre: none
int size(List L);

// lookup()
// returns the value v such that (k, v) is in D, or returns NULL if no 
// such value v exists.
// pre: none
char* lookup(List L, char* k);

// insert()
// inserts new (key,value) pair into D
// pre: lookup(D, k)==NULL
void insert(List L, char* k, char* v);

// delete()
// deletes pair with the key k
// pre: lookup(L, k)!=NULL
void delete(List L, char* k);

// makeEmpty()
// re-sets L to the empty state.
// pre: none
void makeEmpty(List L);

// printList()
// pre: none
// prints a text representation of D to the file pointed to by out
void printList(FILE* out, List L);

#endif
