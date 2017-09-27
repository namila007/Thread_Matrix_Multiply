function [y,A,B]=generate(m1,n1,m2,n2)
A=rand(m1,n1);
B=rand(m2,n2);
fileID = fopen('A.txt','w');
fprintf(fileID,'%d\n%d\n',m1,n1);
for n=1:m1
    for k=1:n1
        fprintf(fileID,'%f\n',A(n,k));
    end
end
fclose(fileID);
fileID = fopen('B.txt','w');
fprintf(fileID,'%d\n%d\n',m2,n2);
for n=1:m2
    for k=1:n2
        fprintf(fileID,'%f\n',B(n,k));
    end
end
fclose(fileID);

y=A*B;
fileID = fopen('answr.txt','w');
fprintf(fileID,'%d\n%d\n',m1,n2);
for n=1:m1
    for k=1:n2
        fprintf(fileID,'%.4f\n',y(n,k));
    end
end
fclose(fileID);

end