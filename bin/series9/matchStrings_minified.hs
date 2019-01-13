import qualified Data.Map as Map
convertTable = Map.fromList $ zip "ACGT" "TGCA"
invertDNA dna = foldr (\m acc -> case m of (Just c) -> c:acc
				           Nothing  -> acc) [] $ map (flip Map.lookup convertTable) dna
isValidDNA []  = False
isValidDNA dna = length dna == length (invertDNA dna)
findFirstMatch m = findFirstMatch' 0 $ invertDNA m
findFirstMatch' n match base
  | not (isValidDNA match) || not (isValidDNA base) || lm > length tb = -1
  | match == take lm base = n
  | otherwise = findFirstMatch' (n+1) match tb
  where lm = length match
	tb = tail base
