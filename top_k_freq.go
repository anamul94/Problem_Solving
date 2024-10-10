// You can edit this code!
// Click here and start typing.
package main

import (
	"fmt"
	"sort"
)

type KeyValue struct {
	Key   int
	Value int
}

func main() {
	nums := []int{1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 4}
	myMap := make(map[int]int)
	for i := 0; i < len(nums); i++ {
		myMap[nums[i]]++
	}

	kvSlice := make([]KeyValue, len(myMap))
	i := 0
	for key, value := range myMap {
		kvSlice[i] = KeyValue{Key: key, Value: value}
		i++
	}

	sort.Slice(kvSlice, func(i, j int) bool {
		fmt.Println(i)
		return kvSlice[i].Value > kvSlice[j].Value
	})

	fmt.Println("Sorted map by value:")

	result := []int{}

	for n := 0; n < 2; n++ {
		result = append(result, kvSlice[n].Key)
	}

	fmt.Println(result)

}
////



optimize sols
import (
    "container/heap"
    "fmt"
)

// Define a custom heap structure
type KeyValue struct {
    Key   int
    Value int
}

// Min-Heap based on frequency (KeyValue.Value)
type MinHeap []KeyValue

func (h MinHeap) Len() int           { return len(h) }
func (h MinHeap) Less(i, j int) bool { return h[i].Value < h[j].Value }
func (h MinHeap) Swap(i, j int)      { h[i], h[j] = h[j], h[i] }

func (h *MinHeap) Push(x interface{}) {
    *h = append(*h, x.(KeyValue))
}

func (h *MinHeap) Pop() interface{} {
    old := *h
    n := len(old)
    x := old[n-1]
    *h = old[0 : n-1]
    return x
}

func topKFrequent(nums []int, k int) []int {
    // Step 1: Build frequency map
    myMap := make(map[int]int)
    for _, num := range nums {
        myMap[num]++
    }

    // Step 2: Use a min-heap to store the top k elements
    h := &MinHeap{}
    heap.Init(h)

    // Step 3: Add items to the heap
    for key, value := range myMap {
        heap.Push(h, KeyValue{Key: key, Value: value})
        if h.Len() > k {
            heap.Pop(h) // Remove the smallest element if size exceeds k
        }
    }

    // Step 4: Extract elements from the heap to get the result
    result := make([]int, 0, k)
    for h.Len() > 0 {
        kv := heap.Pop(h).(KeyValue)
        result = append(result, kv.Key)
    }

    return result
}

