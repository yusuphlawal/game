# PowerShell script to compile and run the Minimal Text Adventure without Maven
$src = 'src\com\example\game\*.java'
$out = 'out'

# prepare output
Remove-Item -Path $out -Recurse -Force -ErrorAction SilentlyContinue
New-Item -ItemType Directory -Path $out | Out-Null

# compile
Write-Host "Compiling Java sources..."
javac -d $out $src
if ($LASTEXITCODE -ne 0) { Write-Error "Compilation failed (javac exit code $LASTEXITCODE)"; exit $LASTEXITCODE }

# run
Write-Host "Running the game..."
java -cp $out com.example.game.Main
