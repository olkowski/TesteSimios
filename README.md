# Instruções API Teste Siomos

Testa DNA.

Endpoint "/simian"
Descrição: Verificar se o DNA enviado como parâmetro é de um Humano ou Símios.
Parâmetros de entrada: Array de String (NxN) com o DNA a ser testado.
Rertono: será retornado o codigo HTTP 200-OK caso o DNA seja de um Símios caso contrário HTTP 403-FORBIDDEN.
Autenticação: Não requer Autenticação.
Metódo HTTP: POST
URL: http://testesimios-env-1.eba-s34dx58s.us-east-2.elasticbeanstalk.com/simian

Estatistica
Endpoint "/stats"
Descrição: retorna as estatísticas de verificações de DNA
Parâmetros de entrada: sem parâmetros.
Rertono: Json com a quantidade de DNA’s símios, quantidade de DNA’s humanos, e a proporção de símios para a população humana.
Exemplo: {"count_mutant_dna": 40, "count_human_dna": 100: "ratio": 0.4}
Autenticação: Não requer Autenticação.
Metódo HTTP: GET
URL: http://testesimios-env-1.eba-s34dx58s.us-east-2.elasticbeanstalk.com/stats