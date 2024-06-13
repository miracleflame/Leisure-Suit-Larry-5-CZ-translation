;;; Sierra Script 1.0 - (do not remove this comment)
(script# 155)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Class_993_0)
(use Game)

(public
	passwordTest 0
)

(local
	[local0 10]
	[local10 10]
	local20
)
(procedure (localproc_0170 &tmp temp0)
	(if (not (StrCmp @local10 {NONE}))
		(= temp0
			(proc255_0
				{Pokud chcete použít heslo pro ochranu této hry, vyberte níže možnost "Heslo".}
				106
				81
				{Proè se obtìžovat?}
				1
				81
				{Heslo}
				2
				80
				{Kapka prevence...}
				70
				160
				67
				3
				-1
			)
		)
	else
		(++ local20)
		(= temp0
			(proc255_0
				{Prosím, zadejte své heslo,\npøesnì tak, jak jste ho napsali:}
				106
				41
				@local0
				20
				106
				81
				{Ok}
				1
				81
				{Zmìnit}
				2
				80
				{Hej! To jsi zase ty?}
				70
				160
				67
				3
				-1
			)
		)
	)
	(localproc_01f3)
	(return temp0)
)

(procedure (localproc_01f3 &tmp temp0 temp1)
	(= temp0 0)
	(while (< temp0 (StrLen @local0))
		(if (> (= temp1 (StrAt @local0 temp0)) 90)
			(StrAt @local0 temp0 (- temp1 32))
		)
		(++ temp0)
	)
)

(procedure (localproc_0231 &tmp temp0 temp1 temp2)
	(= temp0 0)
	(while (< temp0 (StrLen @local10))
		(= temp2 (- 167 temp0))
		(= temp1 (^ (StrAt @local10 temp0) temp2))
		(StrAt @local10 temp0 temp1)
		(++ temp0)
	)
)

(procedure (localproc_0270 &tmp [temp0 10])
	(if (!= (MEMORY_DRV open: 1) 0)
		(MEMORY_DRV readString: @local10 20 read: @temp0 8 close:)
		(= global163 (ReadNumber @temp0))
	else
		(StrCpy @local10 {NONE})
		(= global163 1000)
		(localproc_02c9)
	)
	(localproc_0231)
)

(procedure (localproc_02c9 &tmp [temp0 10])
	(if (!= (MEMORY_DRV open: 2) 0)
		(localproc_0231)
		(Format @temp0 155 3 global163)
		(MEMORY_DRV
			writeString: @local10
			writeString: {\n}
			writeString: @temp0
			close:
		)
	)
)

(instance passwordTest of Rm
	(properties
		picture 110
		style $0007
	)
	
	(method (init &tmp temp0)
		(super init:)
		(localproc_0270)
		(if (StrCmp @local10 {NONE})
			(= local0 0)
		else
			(StrCpy @local0 @local10)
		)
		(while
			(and
				(< local20 5)
				(or
					(not (= temp0 (localproc_0170)))
					(StrCmp @local10 @local0)
				)
			)
		)
		(cond 
			((== local20 5)
				(proc255_0 155 0 80 {Pìt chyb a konèíš!})
				(= global4 1)
				(return)
			)
			((== temp0 2)
				(proc255_2 @local0 20 {Prosím, zadejte své nové heslo:})
				(localproc_01f3)
				(StrCpy @local10 @local0)
				(localproc_02c9)
				(proc255_4 155 1 @local0 80 {Nìkam si to zapište!})
			)
		)
		(DrawPic 111)
		(if
			(proc255_0
				155
				2
				81
				{Obnovit}
				1
				81
				{Pokraèovat}
				0
				80
				{Vítejte zpìt!}
				70
				160
				67
				3
				-1
			)
			(gGame restore:)
		)
		(DisposeScript 993)
		(global2 newRoom: 160)
	)
)

(instance MEMORY_DRV of Class_993_0
	(properties
		name "MEMORY.DRV"
	)
)
