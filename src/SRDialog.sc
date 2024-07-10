;;; Sierra Script 1.0 - (do not remove this comment)
(script# 990)
(include sci.sh)
(use Main)
(use Class_255_0)
(use n932)
(use n940)
(use Class_993_0)

(public
	proc990_0 0
)

(local
	gGameParseLang
	local1 ;default
	local2 ;i
	local3 ;numGames
	local4 ;selected
	local5 ;theStatus
	[local6 4] = [{Obnovit} {__Uložit__} {Nahradit} {Nahradit}]
	[local10 4] = [{Vyberte hru, kterou chcete obnovit.} {Zadejte popis této uložené hry.} {Tato složka/disk nemùže pojmout žádné další uložené hry. Musíte nahradit nìkterou z uložených her, nebo pomocí funkce Zmìnit složku uložit hru do jiné složky/disku.} {Tato složka/disk nemùže pojmout žádné další uložené hry. Musíte nahradit nìkterou z uložených her, nebo pomocí funkce Zmìnit složky uložit hru do jiné složky/disku.}]
)

;(procedure (GetDirectory where &tmp result [newDir 33] [str 100] saveParseLang)
(procedure (proc990_0 param1 &tmp temp0 [temp1 33] [temp34 100] temp134)
	(repeat
		(= temp134 (gGame parseLang:))
		(gGame parseLang: 1)
		(= temp0
			(proc255_0 ; "New save-game directory:"
				990 1
				#font 0
				#edit (StrCpy @temp1 param1) 29
				#button {OK} 1
				#button {Zrušit} 0
			)
		)
		(gGame parseLang: temp134)
		(if (not temp0)
			(return 0)
		)
		(if (not (StrLen @temp1))
			(GetCWD @temp1)
		)
		(if (ValidPath @temp1)
			(StrCpy param1 @temp1)
			(return 1)
		else
			(proc255_0 (Format @temp34 990 2 @temp1) #font 0) ; "%s is not a valid directory"
		)
	)
)

(procedure (localproc_05b3)
	(return
		(cond 
			((== self Restore) 0)
			((localproc_0927) 1)
			(local3 2)
			(else 3)
		)
	)
)

(procedure (localproc_0927)
	(if (< local3 20) (CheckFreeSpace global29))
)

(procedure (localproc_0936)
	(proc255_0 990 3 33 0)
)

(class SRDialog of Dialog
	(properties
		elements 0
		size 0
		text 0
		window 0
		theItem 0
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		time 0
		busy 0
		caller 0
		seconds 0
		lastSeconds 0
	)
	
	(method (init param1 param2 param3)
		(proc932_3)
		(= gGameParseLang (gGame parseLang?))
		(gGame parseLang: 1)
		(= window gWindow)
		(= nsBottom 0)
		(if
			(==
				(= local3 (GetSaveFiles (gGame name?) param2 param3))
				-1
			)
			(return 0)
		)
		(if (== (= local5 (localproc_05b3)) 1)
			(editI
				text: (StrCpy param1 param2)
				font: global23
				setSize:
				moveTo: 4 4
			)
			(self add: editI setSize:)
		)
		(selectorI
			text: param2
			font: global23
			setSize:
			moveTo: 4 (+ nsBottom 4)
			state: 2
		)
		(= local2 (+ (selectorI nsRight?) 4))
		(okI
			text: [local6 local5]
			setSize:
			moveTo: local2 (selectorI nsTop?)
			state:
				(if
				(or (and (== local5 0) (not local3)) (== local5 3))
					0
				else
					3
				)
		)
		(deleteI
			setSize:
			moveTo: local2 (+ (okI nsBottom?) 4)
			state: (if (not local3) 0 else 3)
		)
		(changeDirI
			setSize:
			moveTo: local2 (+ (deleteI nsBottom?) 4)
			state: (& (changeDirI state?) $fff7)
		)
		(cancelI
			setSize:
			moveTo: local2 (+ (changeDirI nsBottom?) 4)
			state: (& (cancelI state?) $fff7)
		)
		(self
			add: selectorI okI deleteI changeDirI cancelI
			setSize:
		)
		(textI
			text: [local10 local5]
			setSize: (- (- nsRight nsLeft) 8)
			moveTo: 4 4
		)
		(= local2 (+ (textI nsBottom?) 4))
		(self eachElementDo: #move 0 local2)
		(self add: textI setSize: center: open: 4 -1)
		(return 1)
	)
	
	;(method (doit theComment &tmp temp0 temp1 temp2 [temp3 361] [temp364 21] [temp385 140])
	(method (doit param1 &tmp temp0 temp1 temp2 [temp3 361] [temp364 21] [temp385 140])
		(if (and (== self Restore) argc param1)
			(if
				(==
					;(= temp0 (FileIO fiOPEN (Format @temp385 990 0 (gGame name:)))) ; "%ssg.dir"
					(= temp0 (FileIO 0 (Format @temp385 990 0 (gGame name:)))) ; "%ssg.dir" 
					-1
				)
				(return)
			)
			;(FileIO fiCLOSE temp0)
			(FileIO 1 temp0)
		)
		(if (not (self init: param1 @temp3 @temp364))
			(return -1)
		)
		(repeat
			(= local1
				(switch local5
					(0
						(if local3 okI)
					)
					(1 editI)
					(2 okI)
					(else changeDirI)
				)
			)
			(= local2 (super doit: local1))
			(= temp2 (* (= local4 (selectorI indexOf: (selectorI cursor:))) 18))
			(if (== local2 changeDirI)
				(self dispose:)
				(if
					(and
						(proc990_0 global29)
						(==
							(= local3
								(GetSaveFiles (gGame name:) @temp3 @temp364)
							)
							-1
						)
					)
					(= temp1 -1)
					(break)
				)
				(self init: param1 @temp3 @temp364)
			else
				(if (and (== local5 2) (== local2 okI))
					(self dispose:)
					(if (GetReplaceName doit: (StrCpy param1 @[temp3 temp2]))
						(= temp1 [temp364 local4])
						(break)
					)
					(self init: param1 @temp3 @temp364)
					(continue)
				)
				(if (and (== local5 1) (or (== local2 okI) (== local2 editI)))
					(if (== (StrLen param1) 0)
						(self dispose:)
						(localproc_0936)
						(self init: param1 @temp3 @temp364)
						(continue)
					)
					(= temp1 -1)
					(for ((= local2 0)) (< local2 local3) ((++ local2))
						(breakif
							(not
								(= temp1 (StrCmp param1 @[temp3 (* local2 18)]))
							)
						)
					)
					(if (not temp1)
						(= temp1 [temp364 local2])
						(break)
					)
					(if (== local3 20)
						(= temp1 [temp364 local4])
						(break)
					)
					(for ((= temp1 0)) 1 ((++ temp1))
						(for ((= local2 0)) (< local2 local3) ((++ local2))
							(breakif (== temp1 [temp364 local2]))
						)
						(if (== local2 local3)
							(break)
						)
					)
					(break)
				)
				(cond
					((== local2 deleteI)
						(self dispose:)
						(if
							(not
								(proc940_0
									{Jste si jisti, že chcete\0D\nsmazat tuto uloženou hru?}
									106
									81
									{ Ne_}
									0
									81
									{Ano}
									1
								)
							)
							(self init: param1 @temp3 @temp364)
						else
							((= temp0 (Class_993_0 new:))
								name: (DeviceInfo 7 @temp385 (gGame name:)) ; MakeSaveDirName
								open: 2
							)
							(= temp1 2570)
							(for ((= local2 0)) (< local2 local3) ((++ local2))
								(if (!= local2 local4)
									(temp0 write: @[temp364 local2] 2)
									(temp0 writeString: @[temp3 (* local2 18)])
									(temp0 write: @temp1 1)
								)
							)
							(= temp1 -1)
							(temp0 write: @temp1 2 close: dispose:)
							(DeviceInfo
								8 ; MakeSaveFileName
								@temp385
								(gGame name:)
								[temp364 local4]
							)
							;(FileIO fiUNLINK @temp385)
							(FileIO 4 @temp385)
							(self init: param1 @temp3 @temp364)
						)
					)
					((== local2 okI)
						(= temp1 [temp364 local4])
						(break)
					)
					((or (== local2 0) (== local2 cancelI))
						(= temp1 -1)
						(break)
					)
					((== local5 1)
						(editI
							cursor: (StrLen (StrCpy param1 @[temp3 temp2]))
							draw:
						)
					)
				)
			)
		)
		(DisposeScript 993)
		(DisposeScript 940)
		(self dispose:)
		(DisposeScript 990)
		(return temp1)
	)

	(method (dispose)
		(proc932_4)
		(gGame parseLang: gGameParseLang)
		(super dispose: &rest)
	)
)

(class Restore of SRDialog
	(properties
		elements 0
		size 0
		text {Obnovit hru}
		window 0
		theItem 0
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		time 0
		busy 0
		caller 0
		seconds 0
		lastSeconds 0
	)
)

(class Save of SRDialog
	(properties
		elements 0
		size 0
		text {Uložit hru}
		window 0
		theItem 0
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		time 0
		busy 0
		caller 0
		seconds 0
		lastSeconds 0
	)
)

(instance GetReplaceName of Dialog
	(properties)
	
	(method (doit param1 &tmp temp0 gGameParseLang_2)
		(= gGameParseLang_2 (gGame parseLang?))
		(gGame parseLang: 1)
		(= window gWindow)
		(text1 setSize: moveTo: 4 4)
		(self add: text1 setSize:)
		(oldName
			text: param1
			font: global23
			setSize:
			moveTo: 4 nsBottom
		)
		(self add: oldName setSize:)
		(text2 setSize: moveTo: 4 nsBottom)
		(self add: text2 setSize:)
		(newName
			text: param1
			font: global23
			setSize:
			moveTo: 4 nsBottom
		)
		(self add: newName setSize:)
		(button1 nsLeft: 0 nsTop: 0 setSize:)
		(button2 nsLeft: 0 nsTop: 0 setSize:)
		(button2
			moveTo: (- nsRight (+ (button2 nsRight?) 4)) nsBottom
		)
		(button1
			moveTo: (- (button2 nsLeft?) (+ (button1 nsRight?) 4)) nsBottom
		)
		(self add: button1 button2 setSize: center: open: 0 -1)
		(= temp0 (super doit: newName))
		(self dispose:)
		(if (not (StrLen param1))
			(localproc_0936)
			(= temp0 0)
		)
		(gGame parseLang: gGameParseLang_2)
		(return (if (== temp0 newName) else (== temp0 button1)))
	)
)

(instance selectorI of DSelector
	(properties
		x 36
		y 8
	)
)

(instance editI of DEdit
	(properties
		max 35
	)
)

(instance okI of DButton
	(properties)
)

(instance cancelI of DButton
	(properties
		text { Zrušit_}
	)
)

(instance changeDirI of DButton
	(properties
		text {Zmìnit\0D\nsložku}
	)
)

(instance deleteI of DButton
	(properties
		text { Smazat_}
	)
)

(instance textI of DText
	(properties
		font 0
	)
)

(instance text1 of DText
	(properties
		text {Nahradit uloženou pozici}
		font 0
	)
)

(instance text2 of DText
	(properties
		text {novou pozicí:}
		font 0
	)
)

(instance oldName of DText
	(properties)
)

(instance newName of DEdit
	(properties
		max 35
	)
)

(instance button1 of DButton
	(properties
		text {Nahradit}
	)
)

(instance button2 of DButton
	(properties
		text {Zrušit}
	)
)
