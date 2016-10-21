(ns euler.problem5)

;; Smallest multiple
;; Problem 5

;; 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

;; What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?

(defn div20? [n]
  (every? true? (for [x (range 1 21)] (= 0 (mod n x)))))
  
(def problem5 
  (first (filter div20? (iterate inc 1))))
