(ns euler.problem9)

; Special Pythagorean triplet
; Problem 9
; 
; A Pythagorean triplet is a set of three natural numbers, a < b < c, 
; for which a2 + b2 = c2
; 
; For example, 32 + 42 = 9 + 16 = 25 = 52.
; 
; There exists exactly one Pythagorean triplet for which a + b + c = 1000.
; Find the product abc.


(def problem9 
  (for [a (range 500) 
        b (range 500) 
        c (range 500)
        :let [s (+ a b c)] 
        :when (and 
                (< a b c)
                (= s 1000) 
                (= (+ 
                      (Math/pow a 2) 
                      (Math/pow b 2)) 
                   (Math/pow c 2)))] 
    (* a b c)))
