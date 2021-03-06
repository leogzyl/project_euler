(ns euler.problem4)

;; Largest palindrome product
;; Problem 4

;; A palindromic number reads the same both ways. 
;; The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

;; Find the largest palindrome made from the product of two 3-digit numbers.

(defn palindrome? [n]
  (= (seq (str n)) 
     (reverse (seq (str n)))))

(def problem4 
  (apply max (for [x (range 100 1000) 
                   y (range 100 1000)
                   :let [p (* x y)] 
                   :when (palindrome? p)] 
               p)))
