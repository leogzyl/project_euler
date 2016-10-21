(ns euler.problem14)

; Longest Collatz sequence
; Problem 14

; The following iterative sequence is defined for the set of positive integers:

; n → n/2 (n is even)
; n → 3n + 1 (n is odd)

; Using the rule above and starting with 13, we generate the following sequence:
; 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1

; It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

; Which starting number, under one million, produces the longest chain?

; NOTE: Once the chain starts the terms are allowed to go above one million.

(defn next-collatz [n]
  (if (even? n)
    (/ n 2)
    (+ (* 3 n) 1)))

(defn collatz-seq-count [start]
  (loop [n start accum 0]
    (if (= n 1)
      (inc accum)
      (recur (next-collatz n) (inc accum)))))

(defn num-with-largest-collatz-seq [limit]
  (loop [n 1 accum [1 1]]
    (if (= n limit)
      (last accum)
      (let [c (collatz-seq-count n)
            new-accum (if (> c (first accum)) [c n] accum) ]
        (recur (inc n) new-accum)))))

(def problem14 (num-with-largest-collatz-seq 1000000))
