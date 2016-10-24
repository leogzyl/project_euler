(ns euler.problem15)

; Lattice paths
; Problem 15

; Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down,
; there are exactly 6 routes to the bottom right corner.

; How many such routes are there through a 20×20 grid?

; -----------------------------------------------
  
; https://en.wikipedia.org/wiki/Permutation#Permutations_of_multisets

; Notice that every path is formed by n vertical and n horizontal segments,
; and each type of segment is repeated n times, so we are dealing 
; with permutations of multisets:

; 2n!/(n!)^2

(defn bigexp [num exponent]
  (if (= exponent 1)
    num
    (* (bigint num) (bigexp num (dec exponent)))))

(defn bigfact [n]
  (if (= n 1)
    n
    (* (bigint n) (bigfact (dec n)))))

(def problem15 (/ (bigfact 40) (bigexp (bigfact 20) 2)))
