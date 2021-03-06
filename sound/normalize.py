def normalize(sound):
  largest = 1
  for s in getSamples(sound):        
    largest = max(largest, getSampleValue(s))    
    amplification = 32767.0 / largest

  print "Largest sample value in original sound was",  largest 
  print "Amplification multiplier is", amplification

  for s in getSamples(sound):      
    louder =  amplification * getSampleValue(s)  
    setSampleValue(s, louder)